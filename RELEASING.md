Release Process
===============

Release
-------

1. Increment the version in `clean-jack/bintray.gradle` in case of any relevant update in the library,
    such as internal and/or fix changes.

2. Update the `CHANGELOG.md` file describing the internal and/or fix changes.

3. Update READ.ME with the new library version.

3. Commit the changes with `git commit -am "Preparing version X.Y.Z"`, replacing 'X.Y.Z' with the
    number of the new version.

4. Create a annotated tag with `git tag -a X.Y.Z -m "Version X.Y.Z"`, replacing 'X.Y.Z' with the
    number of the new version.

5. Push (`git push --follow-tags`).

6. :shipit: