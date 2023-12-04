package com.github.fullcycle.catalog.admin.application.castmember.retrieve.get;

import com.github.fullcycle.catalog.admin.application.UseCase;

public sealed abstract class GetCastMemberByIdUseCase
    extends UseCase<String, CastMemberOutput>
    permits DefaultGetCastMemberByIdUseCase {
}
