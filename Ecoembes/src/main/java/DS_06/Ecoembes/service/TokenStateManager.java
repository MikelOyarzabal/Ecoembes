package DS_06.Ecoembes.service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import DS_06.Ecoembes.dao.ContenedorRepository;
import DS_06.Ecoembes.entity.TokenState;
import DS_06.Ecoembes.entity.User;

@Component
	public class TokenStateManager {
	    
	    private static class TokenInfo {
	        private User user;
	        private TokenState state;
	        private LocalDateTime createdAt;
	        private LocalDateTime expiresAt;
	        
	        public TokenInfo(User user) {
	            this.user = user;
	            this.state = TokenState.ACTIVE;
	            this.createdAt = LocalDateTime.now();
	            this.expiresAt = LocalDateTime.now().plusHours(1); // 1 hora de expiración
	        }
	        
	        public boolean isValid() {
	            return state == TokenState.ACTIVE && 
	                   LocalDateTime.now().isBefore(expiresAt);
	        }
	        
	        public void revoke() {
	            this.state = TokenState.REVOKED;
	        }
	        
	        public void expire() {
	            this.state = TokenState.EXPIRED;
	        }
	    }
	    
	    // Almacenamiento thread-safe de tokens
	    private final Map<String, TokenInfo> tokenStore = new ConcurrentHashMap<>();

	    // Sincronizado para generación única
	    public synchronized String generateToken(User user) {
	        String token;
	        do {
	            token = Long.toHexString(System.nanoTime()) + 
	                    Long.toHexString(System.currentTimeMillis());
	        } while (tokenStore.containsKey(token));
	        
	        tokenStore.put(token, new TokenInfo(user));
	        return token;
	    }
	    
	    public Optional<User> validateToken(String token) {
	        TokenInfo tokenInfo = tokenStore.get(token);
	        if (tokenInfo != null && tokenInfo.isValid()) {
	            return Optional.of(tokenInfo.user);
	        }
	        return Optional.empty();
	    }
	    
	    public boolean revokeToken(String token) {
	        TokenInfo tokenInfo = tokenStore.get(token);
	        if (tokenInfo != null && tokenInfo.isValid()) {
	            tokenInfo.revoke();
	            return true;
	        }
	        return false;
	    }
	    
	    public void cleanupExpiredTokens() {
	        tokenStore.entrySet().removeIf(entry -> 
	            !entry.getValue().isValid()
	        );
	    }
	    
	    public int getActiveTokensCount() {
	        return (int) tokenStore.values().stream()
	                .filter(TokenInfo::isValid)
	                .count();
	    }
	}