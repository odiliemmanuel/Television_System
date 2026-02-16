import unittest

from Television import Television


class TelevisionTest(unittest.TestCase):
    
    def setUp(self):
        self.television : Television = Television()

    def test_that_i_can_put_off_tv(self):
        
        self.assertFalse(self.television.turn_off())

