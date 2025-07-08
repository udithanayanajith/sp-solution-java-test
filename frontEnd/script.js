document.addEventListener('DOMContentLoaded', function() {
    const categorySelect = document.getElementById('categories');
    const newsContainer = document.getElementById('news-container');
    const newsList = document.getElementById('news-list');
    const categoryTitle = document.getElementById('category-title');
    const newsDetail = document.getElementById('news-detail');
    const newsTitle = document.getElementById('news-title');
    const newsBody = document.getElementById('news-body');
    const backButton = document.getElementById('back-button');

    let currentNews = [];

    fetch('http://localhost:8081/v1/api/cat')
        .then(response => response.json())
        .then(categories => {
            categories.forEach(category => {
                const option = document.createElement('option');
                option.value = category.catId;
                option.textContent = category.catDescription;
                categorySelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Error fetching categories:', error);
            categorySelect.innerHTML = '<option value="">Error loading categories</option>';
        });

    categorySelect.addEventListener('change', function() {
        const catId = this.value;

        if (!catId) {
            newsContainer.style.display = 'none';
            return;
        }

        fetch(`http://localhost:8081/v1/api/news/allNewsByCatId/${catId}`)
            .then(response => response.json())
            .then(news => {
                currentNews = news;
                displayNewsList(news);

                // Find the selected category name
                const selectedOption = categorySelect.options[categorySelect.selectedIndex];
                categoryTitle.textContent = `News in ${selectedOption.text}`;
                newsContainer.style.display = 'block';
                newsDetail.style.display = 'none';
            })
            .catch(error => {
                console.error('Error fetching news:', error);
                newsList.innerHTML = '<li>Error loading news</li>';
            });
    });

    function displayNewsList(news) {
        newsList.innerHTML = '';

        if (news.length === 0) {
            newsList.innerHTML = '<li>No news found in this category</li>';
            return;
        }

        news.forEach(item => {
            const li = document.createElement('li');
            li.textContent = item.newsHeadLine;
            li.addEventListener('click', () => showNewsDetail(item));
            newsList.appendChild(li);
        });
    }

    function showNewsDetail(newsItem) {
        newsTitle.textContent = newsItem.newsHeadLine;
        newsBody.textContent = newsItem.newsBody;

        newsContainer.style.display = 'none';
        newsDetail.style.display = 'block';
    }

    backButton.addEventListener('click', function() {
        newsDetail.style.display = 'none';
        newsContainer.style.display = 'block';
    });
});