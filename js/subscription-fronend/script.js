class Subscription {
    constructor(firstName, lastName, email, gender, subscriptions) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.gender = gender
        this.subscriptions = subscriptions
    }
}

const formSubscription = document.querySelector("#formSubscription")

formSubscription.addEventListener('submit', (e) => {
    e.preventDefault()
    const formData = new FormData(e.target)
    let subscription = new Subscription()
    // subscription.firstName = formData.get('firstName')
    // subscription.lastName = formData.get('lastName')
    // subscription.email = formData.get('email')
    // subscription.gender = formData.get('gender')
    // console.log(JSON.stringify(subscription));
    
    subscription = Object.fromEntries(formData);
    subscription.subscriptions = formData.getAll("subscriptions")
    
    console.log(JSON.stringify(subscription))
})