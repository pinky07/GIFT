package com.gft.GiFT.projects.addReleaseSnap.businessLogic;


import com.gft.GiFT.projects.addReleaseSnap.businessLogic.inputs.ReleaseSnap;

import java.text.ParseException;

public interface ReleaseSnapService {

    ReleaseSnap createReleaseSnap(ReleaseSnap releaseSnap) throws ParseException;

}
