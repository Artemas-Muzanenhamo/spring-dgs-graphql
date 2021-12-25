# Spring DGS GraphQL

- Simple application running GraphQL with the DGS framework

## Testing

- You can access the GraphQL interface by going to `http://localhost:8080/graphiql`
- Below is an example query: 
```graphql
{
    shows {
        title
        releaseYear
    }
}
```