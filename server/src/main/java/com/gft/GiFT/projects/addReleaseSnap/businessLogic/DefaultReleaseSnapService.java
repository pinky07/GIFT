package com.gft.GiFT.projects.addReleaseSnap.businessLogic;

import com.gft.GiFT.projects.addReleaseSnap.businessLogic.inputs.ReleaseSnap;
import com.gft.GiFT.projects.addReleaseSnap.dataAccess.ReleaseSnapRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class DefaultReleaseSnapService implements ReleaseSnapService {


    private final ReleaseSnapRepository releaseSnapRepository;

    public DefaultReleaseSnapService(ReleaseSnapRepository releaseSnapRepository) {

        this.releaseSnapRepository = releaseSnapRepository;
    }


    @Override
    public ReleaseSnap createReleaseSnap(ReleaseSnap releaseSnap) throws ParseException {

        releaseSnapRepository.save(releaseSnap);

        return releaseSnap;
    }
}