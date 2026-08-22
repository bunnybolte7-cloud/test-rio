interface User {
    id: number;
    name: string;
}

async function fetchUser(): Promise<User> {
    return { id: 1, name: "Alice" };
}

function processUser() {
    // BUG 1: Missing 'await'. 'user' becomes a Promise instance, not the User object.
    const user = fetchUser(); 

    // BUG 2: TypeScript allows this because of the 'as any' cast, 
    // but it will crash or print 'undefined' at runtime.
    const upperName = (user as any).name.toUpperCase();
    console.log(`User name: ${upperName}`);
}

processUser();
