module mylib {
    // exports mylib.lib to MyselfJavaProject;
    opens mylib.lib;

    exports mylib.internal;
}
