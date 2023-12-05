package com.github.fullcycle.catalog.admin.infrastructure.castmember.presenter;

import com.github.fullcycle.catalog.admin.application.castmember.retrieve.get.CastMemberOutput;
import com.github.fullcycle.catalog.admin.application.castmember.retrieve.list.CastMemberListOutput;
import com.github.fullcycle.catalog.admin.infrastructure.castmember.models.CastMemberListResponse;
import com.github.fullcycle.catalog.admin.infrastructure.castmember.models.CastMemberResponse;

public interface CastMemberPresenter {

    static CastMemberResponse present(final CastMemberOutput aMember) {
        return new CastMemberResponse(
                aMember.id(),
                aMember.name(),
                aMember.type().name(),
                aMember.createdAt().toString(),
                aMember.updatedAt().toString()
        );
    }

    static CastMemberListResponse present(final CastMemberListOutput aMember) {
        return new CastMemberListResponse(
                aMember.id(),
                aMember.name(),
                aMember.type().name(),
                aMember.createdAt().toString()
        );
    }
}
