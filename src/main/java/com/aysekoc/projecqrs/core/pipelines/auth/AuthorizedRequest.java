package com.aysekoc.projecqrs.core.pipelines.auth;

import java.util.List;

public interface AuthorizedRequest {
    List<String> getRequiredRoles();
}
