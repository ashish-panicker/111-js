# Creating a Library in Angular

## Prerequisites

- Should have created an account at [npmjs.com](https://www.npmjs.com/)
- Run the following command to install the necessary dependencies:
    ```bash
    # This will allow you to log into npmjs.com from your command line 
    # and publish your package. Provide the username and password you use
    # to log into npmjs.com.
    npm login

    # To verify that you have successfully logged in, run the following
    # command.
    npm whoami
    ```

## Create an angular workspace

To get started with Angular libraries, you need to create an Angular workspace, then you can create a library project inside that workspace.

- Step 1
```bash
    # Create a new angular workspace
    ng new my-workspace --no-create-application

    # Navigate to the new workspace
    cd my-workspace

    # Generate a new library project
    ng generate library my-lib
```

- Step 2 - Open the library in VS Code Editor
- Step 3 - Open the `projects\my-lib\package.json` file in VS Code Editor
- Step 4 - Change the name from `"my-lib" to "@username/my-lib"`
- Step 5 - Continue editing `projects\my-lib\src\lib\` to create your library
- Step 6 - Building and publishing
  ```bash
    # Build the library
    ng build my-lib

    # Navigate to the `dist` directory
    cd dist/my-lib

    # Publish the library
    npm publish --access=public
    ```
- Step 7 - Log into npmjs.com and verify that your library is published
  

## To use the library in your application

- Step 1 - install the library in your application

    ```bash
    # Install the library
    npm install @username/my-lib
    ```
- Step 2 - Open the `app.module.ts` file in VS Code Editor
- Step 3 - Add the following line to the `app.module.ts` file:
    ```typescript
        import { MyLibModule } from '@username/my-lib';
    ```
- Step 4 - Then add the 'MyLibModule' to the `imports` array in the `app.module.ts` file

    ```typescript
        @NgModule({
            ...
            imports: [
                ...
                MyLibModule
            ]
        })
        export class AppModule { }
    ```