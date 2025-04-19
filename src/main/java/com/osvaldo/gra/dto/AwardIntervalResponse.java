package com.osvaldo.gra.dto;

import java.util.List;

public class AwardIntervalResponse {
    private List<ProducerIntervalDTO> min;
    private List<ProducerIntervalDTO> max;

    public AwardIntervalResponse(List<ProducerIntervalDTO> min, List<ProducerIntervalDTO> max) {
        this.min = min;
        this.max = max;
    }

    public List<ProducerIntervalDTO> getMin() {
        return min;
    }

    public void setMin(List<ProducerIntervalDTO> min) {
        this.min = min;
    }

    public List<ProducerIntervalDTO> getMax() {
        return max;
    }

    public void setMax(List<ProducerIntervalDTO> max) {
        this.max = max;
    }
}
