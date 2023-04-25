# Cpu-z-assignment-

<h1>Main Activity</h1>

<p>TabLayout and a ViewPager2, is be used to display fragments with information about the device, system, and battery.

It then finds the ViewPager2 and TabLayout views by their IDs using findViewById(), and sets the adapter of the ViewPager2 to a custom PagerAdapter object. 

The TabLayoutMediator is used to synchronize the tabs of the TabLayout and the pages of the ViewPager2. It takes two arguments: the TabLayout and the ViewPager2, and a lambda expression that sets the text of each tab based on its position. The attach() method is then called on the TabLayoutMediator to connect the two components together.

In summary, this code sets up a TabLayout and ViewPager2 in an Android activity and uses a custom adapter and TabLayoutMediator to display fragments containing information about the device, system, and battery.</p>

<h1>Pager Adapter</h1>
<p> This PagerAdapter class is used to determine which fragment should be displayed for each tab in the ViewPager2. It returns the appropriate fragment based on the tab position provided by the TabLayoutMediator.</p>

<h1>Battery fragment</h1>
<p>In this we get the information of battery</p>

<h1>Device Fragment</h1>
<p>In this fragment we get the manufacturer name,model number,imei,ram.
There is also a commented-out getSystemDetail function that uses the Build class to get various system details, such as Android version, SDK version, model, and manufacturer.

There is a commented-out getIMEI function that attempts to get the IMEI of the device using the TelephonyManager class, but it requires the READ_PHONE_STATE permission, which is not currently being requested or granted in this code.</p>

<h1>System Fragment</h1>
<p>The getCameraMegapixel function uses the CameraManager to retrieve the details of the camera of the device and calculates its megapixels based on the physical size and pixel array size of the camera sensor.

The getTotalInternalStorage function calculates the total internal storage of the device using the StatFs class.

The formatSize function formats the size in bytes into a human-readable format with the appropriate units (e.g. KB, MB, GB, etc.).

The app also retrieves various OpenGL details such as renderer, vendor, version, and extensions using the GLES20 class.</p>
