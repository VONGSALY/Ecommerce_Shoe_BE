package com.example.test.base.authen.filter_chain;

public abstract class TokenFilterChain {
    protected TokenFilterChain tokenHandle;
    public abstract void validate(RequestContext requestContext);
}
