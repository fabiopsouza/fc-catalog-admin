package com.github.fullcycle.catalog.admin.application.video.retrieve.list;

import com.github.fullcycle.catalog.admin.application.UseCase;
import com.github.fullcycle.catalog.admin.domain.pagination.Pagination;
import com.github.fullcycle.catalog.admin.domain.video.VideoSearchQuery;

public abstract class ListVideosUseCase
        extends UseCase<VideoSearchQuery, Pagination<VideoListOutput>> {
}
