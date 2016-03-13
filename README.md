ProperDroid
====
ProperDroid is a gradle plugin and an Android library that simplifies the way that config diferent variant on your project.

## How ProperDroid stores
It get information from your build.gradle and put them on a json file that sotre inside of your `assets` folder. Later, on runtime, help you get them very easy.

## Download and setup
Add these dependencies to your `build.gradle`:

```groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.5.0'
        classpath 'com.jcminarro:properdroid-plugin:0.1.0'
    }
}
apply plugin: 'com.jcminarro.properdroid'

properdroid {
	properdroidvalues = [
	// ProperDroid Config
	]
}

dependencies {
    compile 'com.jcminarro:properdroid:0.1.0'
}
```

## Configure ProperDroid
ProperDroid works with the data that there are into `properdroid` closure. `properdroidvalues` will have a list of different configurations and one by default. The default one is called `default` and to the rest you can use `flavor` name, `build type` name or `variant` name. Inside of every configuration you can add all data that you want in simple key-value parings. Keep in mind that ProperDroid allow you to use the same key on different configurations and it will be overrided following next order: `default` < `flavor` < `buildType` < `variant`

Here is an example with a String value to all variant and another that will be overrided only on `release` variants:

```groovy
properdroid {
	properdroidvalues = [
		default: [
			projectName: "ProperDRoid",
			endpoint: "http://endpoint.dev"
		],
		release: [
			endpoint: "http://endpoint.dev"
		]
	]
}
```

There is an example with more options [here](https://github.com/JcMinarro/ProperDroid/tree/master/properdroid-example)

## Usage
To use ProperDroid into your app you need to get an instance of ProperDroid and ask for the key that you want. 

```java
ProperDroid properdroid = ProperDroid.with(context);
String projectName = properdroid.getString("projectName");
String endpoint = properdroid.getString("endpoint");
``` 

If you use git as your vcs, you should ignore every file of configuration that ProperDroid generates, To do it add next line to your `.gitignore` file
```
# Ignore all ProperDroid generated file into your vcs
**/properdroid.json
```

## Do you want to contribute?
Feel free to add any useful feature to the library, we will be glad to improve it with your help.
I'd love to hear about your use case too, especially if it's not covered perfectly.