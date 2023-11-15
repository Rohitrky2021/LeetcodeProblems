from typing import List
import math

class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        n = len(nums)
        prefix_mod, result = 0, 0

        # There are k mod groups 0...k-1.
        mod_groups = [0] * k
        mod_groups[0] = 1

        for num in nums:
            # Take modulo twice to avoid negative remainders.
            prefix_mod = math.fmod(prefix_mod + num, k)
            
            # Add the count of subarrays that have the same remainder as the current
            # one to cancel out the remainders.
            result += mod_groups[int(prefix_mod)]
            mod_groups[int(prefix_mod)] += 1

        return result
