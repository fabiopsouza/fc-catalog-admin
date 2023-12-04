package com.github.fullcycle.catalog.admin.application.castmember.update;

import com.github.fullcycle.catalog.admin.application.UseCase;

public sealed abstract class UpdateCastMemberUseCase
        extends UseCase<UpdateCastMemberCommand, UpdateCastMemberOutput>
        permits DefaultUpdateCastMemberUseCase {
}
