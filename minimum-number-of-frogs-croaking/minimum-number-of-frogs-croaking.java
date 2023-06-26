class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int frogCount = 0;
        int cCount = 0;
        int rCount = 0;
        int oCount = 0;
        int aCount = 0;
        int kCount = 0;
        for(char c : croakOfFrogs.toCharArray()) {
            if (c == 'c') {
                cCount++;
                frogCount = Math.max(frogCount, cCount - kCount);
            } else if (c == 'r') {
                rCount++;
                if (rCount > cCount) {
                    return -1;
                }
            } else if (c == 'o') {
                oCount++;
                if (oCount > rCount) {
                    return -1;
                }
            } else if (c == 'a') {
                aCount++;
                if (aCount > oCount) {
                    return -1;
                }
            } else {
                kCount++;
                if (kCount > aCount) {
                    return -1;
                }
            }
        }

        if (!(cCount == rCount && cCount == oCount && cCount == aCount && cCount == kCount)) {
            return -1;
        }
        return frogCount;
    }
}