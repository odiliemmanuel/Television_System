class Television:

   def __init__(self):
       self.__channel = 1
       self.__volume = 0
       self.__is_on: bool = False



   def turn_off(self):
       self.__is_on = False

   def turn_on(self):
       self.__is_on = True

   def get_tv_is_on(self)-> bool:
       return self.__is_on

   def increase_volume(self):
       if self.__is_on and self.__volume < 100:
            self.__volume += 1

   def decrease_volume(self):
       if self.__is_on and self.__volume > 0:
            self.__volume -= 1

   def get_volume_level(self) -> int:
       return self.__volume

   def increase_channel(self):
       if self.__is_on and self.__channel < 300:
            self.__channel += 1

   def get_current_channel(self):
       return self.__channel

   def decrease_channel(self):
       if self.__is_on and self.__channel > 1:
            self.__channel -= 1

   def set_channel(self, channel):
       if self.__is_on and channel > 1 and channel < 300:
            self.__channel = channel