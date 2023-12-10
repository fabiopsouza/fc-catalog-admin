package com.github.fullcycle.catalog.admin.application.video.media.upload;

import com.github.fullcycle.catalog.admin.domain.video.Video;
import com.github.fullcycle.catalog.admin.domain.video.VideoMediaType;

public record UploadMediaOutput(
        String videoId,
        VideoMediaType mediaType
) {

    public static UploadMediaOutput with(final Video aVideo, final VideoMediaType aType) {
        return new UploadMediaOutput(aVideo.getId().getValue(), aType);
    }
}
