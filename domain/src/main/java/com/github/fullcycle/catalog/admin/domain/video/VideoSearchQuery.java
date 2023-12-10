package com.github.fullcycle.catalog.admin.domain.video;

import com.github.fullcycle.catalog.admin.domain.castmember.CastMemberID;
import com.github.fullcycle.catalog.admin.domain.category.CategoryID;
import com.github.fullcycle.catalog.admin.domain.genre.GenreID;

import java.util.Set;

public record VideoSearchQuery(
        int page,
        int perPage,
        String terms,
        String sort,
        String direction,
        Set<CastMemberID> castMembers,
        Set<CategoryID> categories,
        Set<GenreID> genres
) {
}
