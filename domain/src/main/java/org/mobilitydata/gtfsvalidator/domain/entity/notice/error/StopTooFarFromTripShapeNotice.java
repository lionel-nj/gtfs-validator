package org.mobilitydata.gtfsvalidator.domain.entity.notice.error;

import org.mobilitydata.gtfsvalidator.domain.entity.notice.NoticeExporter;
import org.mobilitydata.gtfsvalidator.domain.entity.notice.base.ErrorNotice;

import java.io.IOException;

public class StopTooFarFromTripShapeNotice extends ErrorNotice {

    public StopTooFarFromTripShapeNotice(final String stopId, final int stopSequence,
                                         final String tripId, final String shapeId, final double stopShapeThreshold) {
        super("shapes.txt", E_052,
                "Stop too far from trip shape",
                String.format("`stop_id`: `%s` is more than `%s` meters from `shape_id`: `%s` for `trip_id`: `%s` " +
                                "at stop_sequence: `%s`",
                        stopId,
                        stopShapeThreshold,
                        shapeId,
                        tripId,
                        stopSequence),
                null);
        putNoticeSpecific(KEY_EXPECTED_DISTANCE, stopShapeThreshold);
        putNoticeSpecific(KEY_COMPOSITE_KEY_FIRST_PART, "stop_id");
        putNoticeSpecific(KEY_COMPOSITE_KEY_FIRST_VALUE, stopId);
        putNoticeSpecific(KEY_COMPOSITE_KEY_SECOND_PART, "trip_id");
        putNoticeSpecific(KEY_COMPOSITE_KEY_SECOND_VALUE, tripId);
        putNoticeSpecific(KEY_COMPOSITE_KEY_THIRD_PART, "shape_id");
        putNoticeSpecific(KEY_COMPOSITE_KEY_THIRD_VALUE, shapeId);
        putNoticeSpecific(KEY_COMPOSITE_KEY_FOURTH_PART, "stop_sequence");
        putNoticeSpecific(KEY_COMPOSITE_KEY_FOURTH_VALUE, stopSequence);
    }

    @Override
    public void export(final NoticeExporter exporter) throws IOException {
        exporter.export(this);
    }
}
