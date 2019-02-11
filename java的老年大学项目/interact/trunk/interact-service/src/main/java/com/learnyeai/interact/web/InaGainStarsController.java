package com.learnyeai.interact.web;

import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.interact.model.InaGainStars;
import com.learnyeai.interact.service.InaGainStarsWyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author yl
 */
@Component
public class InaGainStarsController extends BaseController<InaGainStars> {
    public static final String BASE_URL = "/InaGainStars/";

    @Autowired
    private InaGainStarsWyService inaGainStarsWyService;

    @Override
    protected WeyeBaseService<InaGainStars> getService() {
        return inaGainStarsWyService;
    }
}
