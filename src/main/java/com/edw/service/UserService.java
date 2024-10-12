package com.edw.service;

import com.edw.model.User;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.Search;
import org.infinispan.query.dsl.Query;
import org.infinispan.query.dsl.QueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *  com.edw.service.UserService
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 12 Oct 2024 14:02
 */
@Service
public class UserService {

    private RemoteCacheManager remoteCacheManager;

    @Autowired
    public UserService(RemoteCacheManager remoteCacheManager) {
        this.remoteCacheManager = remoteCacheManager;
    }

    public List<User> getUsers() {
        final RemoteCache cache = remoteCacheManager.getCache("user");
        QueryFactory queryFactory = Search.getQueryFactory(cache);
        Query<User> query = queryFactory.create("FROM proto.User order by name ASC");

        // execute the query
        return query.execute().list();
    }

    public void save(User user) {
        final RemoteCache cache = remoteCacheManager.getCache("user");
        cache.put(user.getName(), user);
    }
}
