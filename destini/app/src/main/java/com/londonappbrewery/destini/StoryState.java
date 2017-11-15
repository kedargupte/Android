package com.londonappbrewery.destini;

import java.util.InputMismatchException;

/**
 * Created by kedar on 15/11/17.
 */

public class StoryState {

    Integer storyId;
    Integer topButtonId;
    Integer bottomButtonId;

    StoryState(Integer storyId, Integer topButtonId, Integer bottomButtonId) {
        setStoryId(storyId);
        setTopButtonId(topButtonId);
        setBottomButtonId(bottomButtonId);
    }

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public Integer getTopButtonId() {
        return topButtonId;
    }

    public void setTopButtonId(Integer topButtonId) {
        this.topButtonId = topButtonId;
    }

    public Integer getBottomButtonId() {
        return bottomButtonId;
    }

    public void setBottomButtonId(Integer bottomButtonId) {
        this.bottomButtonId = bottomButtonId;
    }
}
