package com.oceaning.user.injection.module

import com.oceaning.user.model.IUserServer
import com.oceaning.user.model.impl.UserServerImpl
import dagger.Component
import dagger.Module
import dagger.Provides

/**
 * Created by ankeranker on 2018/8/12.
 */
@Module
class UserModule {
    @Provides
    fun providesUserService(serverImpl: UserServerImpl):IUserServer{
        return serverImpl
    }


}