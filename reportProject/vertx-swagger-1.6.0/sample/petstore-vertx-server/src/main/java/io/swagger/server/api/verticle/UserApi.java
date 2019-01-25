package io.swagger.server.api.verticle;

import io.swagger.server.api.model.InlineResponseDefault;
import io.swagger.server.api.MainApiException;
import io.swagger.server.api.MainApiHeader;
import io.swagger.server.api.model.ModelUser;
import java.time.OffsetDateTime;
import io.swagger.server.api.util.ResourceResponse;
import java.util.UUID;
import io.swagger.server.api.util.VerticleHelper;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.auth.User;

import java.util.List;
import java.util.Map;

public interface UserApi  {
    //createUser
    void createUser(ModelUser body, Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //createUsersWithArrayInput
    void createUsersWithArrayInput(List<ModelUser> body, Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //createUsersWithListInput
    void createUsersWithListInput(List<ModelUser> body, Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //deleteUser
    void deleteUser(String username, Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //getUserByName
    void getUserByName(String username, Handler<AsyncResult<ResourceResponse<ModelUser>>> handler);
    
    //loginUser
    void loginUser(String username, String password, Handler<AsyncResult<ResourceResponse<String>>> handler);
    
    //logoutUser
    void logoutUser(Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //updateUser
    void updateUser(String username, ModelUser body, Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //uuid
    void uuid(UUID uuidParam, Handler<AsyncResult<ResourceResponse<InlineResponseDefault>>> handler);
    
}