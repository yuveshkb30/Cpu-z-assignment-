# Cpu-z-assignment-

<h1>Main Activity</h1>

<p>TabLayout and a ViewPager2, is be used to display fragments with information about the device, system, and battery.

It then finds the ViewPager2 and TabLayout views by their IDs using findViewById(), and sets the adapter of the ViewPager2 to a custom PagerAdapter object. 

The TabLayoutMediator is used to synchronize the tabs of the TabLayout and the pages of the ViewPager2. It takes two arguments: the TabLayout and the ViewPager2, and a lambda expression that sets the text of each tab based on its position. The attach() method is then called on the TabLayoutMediator to connect the two components together.

In summary, this code sets up a TabLayout and ViewPager2 in an Android activity and uses a custom adapter and TabLayoutMediator to display fragments containing information about the device, system, and battery.</p>

