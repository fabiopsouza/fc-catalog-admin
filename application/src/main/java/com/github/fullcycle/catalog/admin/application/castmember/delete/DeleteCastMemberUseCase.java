package com.github.fullcycle.catalog.admin.application.castmember.delete;

import com.github.fullcycle.catalog.admin.application.UnitUseCase;

public sealed abstract class DeleteCastMemberUseCase
    extends UnitUseCase<String>
    permits DefaultDeleteCastMemberUseCase {
}
