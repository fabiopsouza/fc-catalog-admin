package com.github.fullcycle.catalog.admin.application.castmember.create;

import com.github.fullcycle.catalog.admin.application.UseCase;

public sealed abstract class CreateCastMemberUseCase
        extends UseCase<CreateCastMemberCommand, CreateCastMemberOutput>
        permits DefaultCreateCastMemberUseCase {
}
