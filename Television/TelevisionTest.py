import unittest

from Television.Television import Television


class TelevisionTest(unittest.TestCase):
    
    def setUp(self):
        self.television = Television()



    def test_that_i_can_put_off_tv(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())


    def test_that_i_can_put_on_tv(self):
        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())


    def test_that_i_can_increase_volume(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        self.television.increase_volume()
        self.assertEqual(1, self.television.get_volume_level())


    def test_that_i_can_increase_volume_only_when_tv_is_on(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        self.television.increase_volume()
        self.television.increase_volume()
        self.television.increase_volume()

        self.assertEqual(3, self.television.get_volume_level())


    def test_that_while_increasing_volume_it_doesnt_exceed_100(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        for count in range(201):
            self.television.increase_volume()

        self.assertEqual(100, self.television.get_volume_level())


    def test_that_if_tv_is_off_and_i_increase_volume_volume_still_remains_at_its_initial_state(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        for count in range(201):
            self.television.increase_volume()

        self.assertEqual(0, self.television.get_volume_level())


    def test_that_i_can_decrease_volume(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        self.television.increase_volume()
        self.television.increase_volume()
        self.television.increase_volume()
        self.assertEqual(3, self.television.get_volume_level())

        self.television.decrease_volume()
        self.assertEqual(2, self.television.get_volume_level())


    def test_that_i_can_decrease_volume_only_when_tv_is_on(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        self.television.increase_volume()
        self.television.increase_volume()
        self.television.increase_volume()
        self.assertEqual(3, self.television.get_volume_level())

        self.television.decrease_volume()
        self.assertEqual(2, self.television.get_volume_level())


    def test_that_if_tv_is_off_and_i_decrease_volume_volume_remains_the_same(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        self.television.increase_volume()
        self.television.increase_volume()
        self.television.increase_volume()
        self.assertEqual(3, self.television.get_volume_level())

        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.decrease_volume()
        self.assertEqual(3, self.television.get_volume_level())


    def test_that_while_decreasing_volume_it_doesnt_go_beyond_0(self):
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        for count in range(201):
            self.television.increase_volume()

        self.assertEqual(100, self.television.get_volume_level())

        for count in range(201):
            self.television.decrease_volume()
        self.assertEqual(0, self.television.get_volume_level())


    def test_that_i_can_increase_channel(self):
        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        for count in range(4):
            self.television.increase_channel()

        self.assertEqual(5, self.television.get_current_channel())


    def test_that_i_can_only_increase_channel_when_tv_is_on(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        for count in range(3):
            self.television.increase_channel()

        self.assertEqual(4, self.television.get_current_channel())


    def test_that_if_i_increase_channel_when_tv_is_off_channel_still_remains_at_1(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        for count in range(3):
            self.television.increase_channel()

        self.assertEqual(1, self.television.get_current_channel())


    def test_that_while_channel_can_be_increased_it_doesnt_exceed_300(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        for count in range(301):
            self.television.increase_channel()

        self.assertEqual(300, self.television.get_current_channel())


    def test_that_i_can_decrease_channel(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        for count in range(4):
            self.television.increase_channel()

        self.assertEqual(5, self.television.get_current_channel())

        self.television.decrease_channel()
        self.assertEqual(4, self.television.get_current_channel())


    def test_that_can_only_decrease_channel_when_tv_is_on(self):
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        for count in range(56):
            self.television.increase_channel()

        self.assertEqual(57, self.television.get_current_channel())

        for count in range(20):
            self.television.decrease_channel()

        self.assertEqual(37, self.television.get_current_channel())


    def test_that_if_decrease_channel_when_tv_is_off_channel_still_remains_unchanged(self):
        self.assertFalse(self.television.get_tv_is_on())

        for count in range(56):
            self.television.increase_channel()

        for count in range(20):
            self.television.decrease_channel()

        self.assertEqual(1, self.television.get_current_channel())



    def test_that_while_channel_can_be_decreased_it_doesnt_go_beyond_1(self):
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        for count in range(301):
            self.television.increase_channel()

        self.assertEqual(300, self.television.get_current_channel())

        for count in range(301):
            self.television.decrease_channel()

        self.assertEqual(1, self.television.get_current_channel())


    def test_that_i_can_set_channel(self):
        self.television.turn_off()
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        self.assertTrue(self.television.get_tv_is_on())

        self.television.set_channel(23)
        self.assertEqual(23, self.television.get_current_channel())


    def test_that_i_can_set_channel_when_tv_is_on(self):
        self.assertFalse(self.television.get_tv_is_on())

        self.television.set_channel(23)
        self.assertEqual(1, self.television.get_current_channel())


    def test_that_i_can_only_set_channel_within_the_range_of_1_to_300(self):
        self.assertFalse(self.television.get_tv_is_on())

        self.television.turn_on()
        # self.assertTrue(self.television.get_tv_is_on())

        self.television.set_channel(0)
        # self.assertEqual(1, self.television.get_current_channel())

        self.television.set_channel(301)
        self.assertEqual(1, self.television.get_current_channel())



