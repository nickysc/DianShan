package com.oceaning.baselibrary.injection.scope

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope

/**
 * Created by ankeranker on 2018/8/14.
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class PerComponentScope