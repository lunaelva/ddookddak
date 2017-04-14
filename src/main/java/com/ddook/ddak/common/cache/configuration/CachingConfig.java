package com.ddook.ddak.common.cache.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;

@Configuration
@EnableCaching
public class CachingConfig implements CachingConfigurer {
 
    @Bean(destroyMethod="shutdown")
    public net.sf.ehcache.CacheManager ehCacheManager() {
    	CacheConfiguration staticConfig = new CacheConfiguration();
        staticConfig.setName("boardConfig");  //cache 이름
        staticConfig.setMemoryStoreEvictionPolicy("LRU");  
        //객체의 개수가 maxElementsInMemory에 도달했을 때,메모리 객체를 어떻게 제거할 지에 대한 정책을 지정한다.
//        LRU: 사용이 가장 적었던 것부터 제거한다.
//        FIFO: 먼저 입력된 것부터 제거한다.
//        LFU: 사용량이 적은 것부터 제거한다. 

        staticConfig.setMaxEntriesLocalHeap(100);  //메모리에 저장될 수 있는 객체의 최대 개수      
        staticConfig.setEternal(false);//이 값이 true이면 timeout 관련 설정은 무시되고, Element가 캐시에서 삭제되지 않는다.
        //데이터를 disk에 쓸지 안쓸지 결정
        staticConfig.persistence(new PersistenceConfiguration().strategy(Strategy.NONE));
      		
        staticConfig.setTimeToIdleSeconds(0);  //Element가 존재하는 시간. 이 시간이 지나면 캐시에서 제거된다. 0이면 무한
        staticConfig.setTimeToLiveSeconds(0); //Element가 지정한 시간 동안 사용(조회)되지 않으면 캐시에서 제거된다.0이면 무한
         
        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(staticConfig);		
		
        return net.sf.ehcache.CacheManager.newInstance(config);
    }
     
    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }
 
    @Bean
	@Override
	public org.springframework.cache.interceptor.KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}
 
    @Override
    public CacheResolver cacheResolver() {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public CacheErrorHandler errorHandler() {
        // TODO Auto-generated method stub
        return null;
    }
}
