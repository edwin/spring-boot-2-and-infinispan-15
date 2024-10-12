package com.edw.config;

import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.impl.query.RemoteQuery;
import org.infinispan.query.remote.client.ProtobufMetadataManagerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <pre>
 *  com.edw.config.InfinispanInitializer
 * </pre>
 * 
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 12 Oct 2024 13:51
 */
@Component
public class InfinispanInitializer implements CommandLineRunner {

    @Autowired
    private RemoteCacheManager cacheManager;

    @Override
    public void run(String...args) throws Exception {
        Path proto = Paths.get(RemoteQuery.class.getClassLoader()
                .getResource("proto/User.proto").toURI());
        String protoBufCacheName = ProtobufMetadataManagerConstants.PROTOBUF_METADATA_CACHE_NAME;
        cacheManager.getCache(protoBufCacheName).put("User.proto", Files.readString(proto));

    }

}