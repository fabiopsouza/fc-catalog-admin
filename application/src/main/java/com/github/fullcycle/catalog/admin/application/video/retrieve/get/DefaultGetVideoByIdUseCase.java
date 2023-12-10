package com.github.fullcycle.catalog.admin.application.video.retrieve.get;

import com.github.fullcycle.catalog.admin.domain.exceptions.NotFoundException;
import com.github.fullcycle.catalog.admin.domain.video.Video;
import com.github.fullcycle.catalog.admin.domain.video.VideoGateway;
import com.github.fullcycle.catalog.admin.domain.video.VideoID;

import java.util.Objects;

public class DefaultGetVideoByIdUseCase extends GetVideoByIdUseCase {

    private final VideoGateway videoGateway;

    public DefaultGetVideoByIdUseCase(final VideoGateway videoGateway) {
        this.videoGateway = Objects.requireNonNull(videoGateway);
    }

    @Override
    public VideoOutput execute(final String anIn) {
        final var aVideoId = VideoID.from(anIn);
        return this.videoGateway.findById(aVideoId)
                .map(VideoOutput::from)
                .orElseThrow(() -> NotFoundException.with(Video.class, aVideoId));
    }
}
