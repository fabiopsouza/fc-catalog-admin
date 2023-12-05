package com.github.fullcycle.catalog.admin.infrastructure.castmember.models;

import com.github.fullcycle.catalog.admin.domain.castmember.CastMemberType;

public record CreateCastMemberRequest(String name, CastMemberType type) {
}
