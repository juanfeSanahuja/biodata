package org.opencb.biodata.formats.pedigree;

import org.opencb.biodata.models.core.pedigree.Individual;
import org.opencb.biodata.models.core.pedigree.Pedigree;
import org.opencb.commons.utils.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by imedina on 11/10/16.
 */
public class PedigreeManager {


    public PedigreeManager() {
    }

    public Pedigree parse(Path pedigreePath) throws IOException {
        FileUtils.checkFile(pedigreePath);


        List<String> individualStringLines = Files.readAllLines(pedigreePath);

        List<Individual> individuals = new ArrayList<>(individualStringLines.size());
        for (int i = 0; i < individualStringLines.size(); i++) {
            if (i == 0 && individualStringLines.get(i).startsWith("#")) {
                // Header with variables
            } else {
                // normal line

            }
        }

        // Create the Pedigree object with the accumulated data
        Pedigree pedigree = new Pedigree();
        pedigree.addIndividuals(individuals);

        return pedigree;
    }
}
