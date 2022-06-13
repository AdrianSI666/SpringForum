package com.example.securityv2.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.securityv2.domain.Badge;
import com.example.securityv2.service.BadgeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BadgeController.class})
@ExtendWith(SpringExtension.class)
class BadgeControllerTest {
    @Autowired
    private BadgeController badgeController;

    @MockBean
    private BadgeService badgeService;

    /**
     * Method under test: {@link BadgeController#getBadgeByName(String)}
     */
    @Test
    void testGetBadgeByName3() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.getBadge((String) any())).thenReturn(badge);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/badge/find/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link BadgeController#getBadgeByName(String)}
     */
    @Test
    void testGetBadgeByName4() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.getBadge((String) any())).thenReturn(badge);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/badge/find/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link BadgeController#getBadgeByName(String)}
     */
    @Test
    void testGetBadgeByName5() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.getBadge((String) any())).thenReturn(badge);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/badge/find/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link BadgeController#getBadgeByName(String)}
     */
    @Test
    void testGetBadgeByName6() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.getBadge((String) any())).thenReturn(badge);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/badge/find/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link BadgeController#getBadges()}
     */
    @Test
    void testGetBadges() throws Exception {
        when(this.badgeService.getBadges()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/badges");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BadgeController#getBadges()}
     */
    @Test
    void testGetBadges2() throws Exception {
        when(this.badgeService.getBadges()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/badges");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BadgeController#getBadges()}
     */
    @Test
    void testGetBadges3() throws Exception {
        when(this.badgeService.getBadges()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/badges");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BadgeController#getBadges()}
     */
    @Test
    void testGetBadges4() throws Exception {
        when(this.badgeService.getBadges()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/badges");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BadgeController#getBadges()}
     */
    @Test
    void testGetBadges5() throws Exception {
        when(this.badgeService.getBadges()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/badges");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BadgeController#getBadges()}
     */
    @Test
    void testGetBadges6() throws Exception {
        when(this.badgeService.getBadges()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/badges");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BadgeController#saveBadge(Badge)}
     */
    @Test
    void testSaveBadge() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.saveBadge((Badge) any())).thenReturn(badge);

        Badge badge1 = new Badge();
        badge1.setId(123L);
        badge1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(badge1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/badge/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/user/save"));
    }

    /**
     * Method under test: {@link BadgeController#saveBadge(Badge)}
     */
    @Test
    void testSaveBadge2() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.saveBadge((Badge) any())).thenReturn(badge);

        Badge badge1 = new Badge();
        badge1.setId(123L);
        badge1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(badge1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/badge/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/user/save"));
    }

    /**
     * Method under test: {@link BadgeController#saveBadge(Badge)}
     */
    @Test
    void testSaveBadge3() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.saveBadge((Badge) any())).thenReturn(badge);

        Badge badge1 = new Badge();
        badge1.setId(123L);
        badge1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(badge1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/badge/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/user/save"));
    }

    /**
     * Method under test: {@link BadgeController#updateBadge(Badge)}
     */
    @Test
    void testUpdateBadge() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.updateBadge((Badge) any())).thenReturn(badge);

        Badge badge1 = new Badge();
        badge1.setId(123L);
        badge1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(badge1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/badge/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link BadgeController#updateBadge(Badge)}
     */
    @Test
    void testUpdateBadge2() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.updateBadge((Badge) any())).thenReturn(badge);

        Badge badge1 = new Badge();
        badge1.setId(123L);
        badge1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(badge1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/badge/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link BadgeController#updateBadge(Badge)}
     */
    @Test
    void testUpdateBadge3() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.updateBadge((Badge) any())).thenReturn(badge);

        Badge badge1 = new Badge();
        badge1.setId(123L);
        badge1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(badge1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/badge/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link BadgeController#deleteBadge(Long)}
     */
    @Test
    void testDeleteBadge() throws Exception {
        doNothing().when(this.badgeService).deleteBadge((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/badge/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BadgeController#deleteBadge(Long)}
     */
    @Test
    void testDeleteBadge2() throws Exception {
        doNothing().when(this.badgeService).deleteBadge((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/badge/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BadgeController#deleteBadge(Long)}
     */
    @Test
    void testDeleteBadge3() throws Exception {
        doNothing().when(this.badgeService).deleteBadge((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/badge/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BadgeController#deleteBadge(Long)}
     */
    @Test
    void testDeleteBadge4() throws Exception {
        doNothing().when(this.badgeService).deleteBadge((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/badge/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BadgeController#deleteBadge(Long)}
     */
    @Test
    void testDeleteBadge5() throws Exception {
        doNothing().when(this.badgeService).deleteBadge((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/badge/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BadgeController#deleteBadge(Long)}
     */
    @Test
    void testDeleteBadge6() throws Exception {
        doNothing().when(this.badgeService).deleteBadge((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/badge/delete/{id}", 123L);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BadgeController#getBadgeByName(String)}
     */
    @Test
    void testGetBadgeByName() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.getBadge((String) any())).thenReturn(badge);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/badge/find/{name}", "Name");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }

    /**
     * Method under test: {@link BadgeController#getBadgeByName(String)}
     */
    @Test
    void testGetBadgeByName2() throws Exception {
        Badge badge = new Badge();
        badge.setId(123L);
        badge.setName("Name");
        when(this.badgeService.getBadge((String) any())).thenReturn(badge);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/badge/find/{name}", "Name");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.badgeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"));
    }
}

