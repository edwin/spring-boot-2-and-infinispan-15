package com.edw.config;

import com.edw.model.User;
import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.ProtoSchema;

/**
 * <pre>
 *  com.edw.config.UserIndexSchemaInitializer
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 12 Oct 2024 13:48
 */
@ProtoSchema(
        includeClasses = {
                User.class
        },
        schemaFileName = "User.proto",
        schemaFilePath = "proto/",
        schemaPackageName = "proto")
public interface UserIndexSchemaInitializer extends SerializationContextInitializer {
}
