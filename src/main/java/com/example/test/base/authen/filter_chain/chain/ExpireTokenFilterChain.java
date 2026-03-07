package com.example.test.base.authen.filter_chain.chain;
import com.example.test.base.authen.TokenHelper;
import com.example.test.base.authen.filter_chain.RequestContext;
import com.example.test.base.authen.filter_chain.TokenFilterChain;
import com.example.test.base.error_success_handle.CodeAndMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

@Component("expire-token-filter-chain")
public class ExpireTokenFilterChain extends TokenFilterChain {
    private final TokenFilterChain tokenHandle;

    public ExpireTokenFilterChain(@Qualifier("log-out-filter-chain") TokenFilterChain tokenHandle) {
        this.tokenHandle = tokenHandle;
    }

    @Override
    public void validate(RequestContext requestContext) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        OffsetDateTime exp = TokenHelper.getExpFromToken(requestContext.getAccessToken());
        if (now.isAfter(exp)){
            throw new RuntimeException(CodeAndMessage.ME0101);
        }
        System.out.println("Validate expire token success");
        if (Objects.nonNull(tokenHandle)){
            tokenHandle.validate(requestContext);
        }
    }
}
