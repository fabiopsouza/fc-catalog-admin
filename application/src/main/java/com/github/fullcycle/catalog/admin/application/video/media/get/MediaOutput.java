package com.github.fullcycle.catalog.admin.application.video.media.get;

import com.github.fullcycle.catalog.admin.domain.video.Resource;

public record MediaOutput(
        byte[] content,
        String contentType,
        String name
) {
    public static MediaOutput with(final Resource aResource) {
        return new MediaOutput(
                aResource.content(),
                aResource.contentType(),
                aResource.name()
        );
    }
}
