Jenkins Shared Library

for import this library put in your jenkins file

```
@Library('jenkins-shared-lib')_
```

# Init func 

init function is need to be first action in your stage, and its inject env props.
---

every file name in folder vars is name of function

to create new function create new file in vars folder with the name of your function

and then create function with name call

example if you want to create function with name init

filename: vars/init.groovy
file code:

```
#!/usr/bin/env groovy

def call(someArg) {
    echo "init func from shared lib"
    echo someArg
}
```

use isWindows func to detect if the agent is windows, you can use bashCommand func to run sh scripts on windows


