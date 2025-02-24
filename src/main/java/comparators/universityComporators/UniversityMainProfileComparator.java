package comparators.universityComporators;

import models.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityMainProfileComparator implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getMainProfile().getProfileName(), o2.getMainProfile().getProfileName());
    }
}
