package com.github.fullcycle.catalog.admin.application.video.update;

import com.github.fullcycle.catalog.admin.domain.video.Video;

public record UpdateVideoOutput(String id) {

    public static UpdateVideoOutput from(final Video aVideo) {
        return new UpdateVideoOutput(aVideo.getId().getValue());
    }
}
