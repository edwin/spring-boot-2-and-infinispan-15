package com.edw.repository;

import com.edw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 *  com.edw.repository.UserRepository
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 14 Oct 2024 20:23
 */
public interface UserRepository extends JpaRepository<User, String> {
}
