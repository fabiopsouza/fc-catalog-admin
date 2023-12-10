package com.github.fullcycle.catalog.admin.application.video.retrieve.list;

import com.github.fullcycle.catalog.admin.domain.pagination.Pagination;
import com.github.fullcycle.catalog.admin.domain.video.VideoGateway;
import com.github.fullcycle.catalog.admin.domain.video.VideoSearchQuery;

import java.util.Objects;

public class DefaultListVideosUseCase extends ListVideosUseCase {

    private final VideoGateway videoGateway;

    public DefaultListVideosUseCase(final VideoGateway videoGateway) {
        this.videoGateway = Objects.requireNonNull(videoGateway);
    }

    @Override
    public Pagination<VideoListOutput> execute(final VideoSearchQuery aQuery) {
        return this.videoGateway.findAll(aQuery)
                .map(VideoListOutput::from);
    }
}
