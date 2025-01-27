class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        new_nums = [0] * len(nums)
        pointer_left = 0
        pointer_right = len(nums) - 1
        
        for i in range(len(nums) - 1, -1, -1):
            left_squared = nums[pointer_left] ** 2
            right_squared = nums[pointer_right] ** 2
            
            if left_squared > right_squared:
                new_nums[i] = left_squared
                pointer_left += 1
            else:
                new_nums[i] = right_squared
                pointer_right -= 1
        
        return new_nums