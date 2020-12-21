import axios from 'axios'

export const getBooks = opts => {
    const config = { headers: { 'Accept': 'application/json' },
        // auth: { username: 'user1', password: 'user1Pass' },
        // params: {}
    };
    axios.get("/book/findAll", config)
        .then(res => this.setState({ books: res.data }))
        .catch(function (error) {
            console.log(error);
        });
};
